package com.example.connectingroomtostate

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import com.example.connectingroomtostate.ui.theme.ConnectingRoomToStateTheme
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    val inventoryRepository by lazy { InventoryRepository(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConnectingRoomToStateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val onUpdateItem: (item: Item) -> Unit = { item ->
                        runBlocking(IO) { inventoryRepository.updateItem(Item) }
                    }
                    val items = inventoryRepository.getAllItems().observeAsState(emptyList())
                    InventoryList(items = items.value, onUpdateItem = onUpdateItem)
                }
            }
        }
    }
}

@Composable
fun InventoryList(items:List<Item>,onUpdateItem:(item:Item)->Unit)
{
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        LazyColumn{
            itemsIndexed(items){_,item ->
                InventoryList(items,onUpdateItem)
            }
        }
    }
}
@Composable
fun InventoryItem(item:Item,onUpdateItem:(item:Item)->Unit)
{
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = item.name)
        TextButton(onClick = {
            onUpdateItem(item.copy(quantity = item.quantity-1))
        }) {
            Text(text = "-")
        }
        Text(text = item.quantity.toString())
        TextButton(onClick = {
            onUpdateItem(item.copy(quantity = item.quantity+1))
        }) {
            Text(text = "+")
        }
    }
}
@Entity
data class Item(
    @PrimaryKey val id:Int,
    val name:String,
    val quantity:Int
)
@Dao
interface InventoryDao{
    @Query("SELECT * FROM Item ORDER BY name")
    fun getAllItems():LiveData<List<Item>>
    @Update
    fun updateItem(item:Item)
}
@Database(entities = [Item::class], version = 1)
abstract class InventoryDatabase:RoomDatabase()
{
    abstract fun inventoryDao():InventoryDao
}
class InventoryRepository(context: Context)
{
    private val database = Room.databaseBuilder(
        context.applicationContext,InventoryDatabase::class.java,
        "inventory.db"
    ).createFromAsset("database/inventory.db").build()
    fun getAllItems()=database.inventoryDao().getAllItems()
    fun updateItem(item:Item)=database.inventoryDao().updateItem(item)
}