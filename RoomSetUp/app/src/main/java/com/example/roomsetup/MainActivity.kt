package com.example.roomsetup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomsetup.ui.theme.RoomSetUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomSetUpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
        val db= Room.databaseBuilder(applicationContext,AppDataBase::class.java,
            "database-name").build()
        val playerDao=db.playerDao()
        val players = playerDao.getAll()
    }
}
@Entity //Entity that Represents the table
data class Player(
    @PrimaryKey val id:Int,
    val name:String,
    val age:Int
)
@Dao //Dao that contains Crud Operations
interface PlayerDao{
    @Query("SELECT * FROM player")
    fun getAll():List<Player>
    @Insert
    fun insertAll(vararg players:Player)
    @Delete
    fun delete(player: Player)
}
@Database(entities = [Player::class], version = 1)//provides connection to underlying app database
abstract class AppDataBase:RoomDatabase(){
    abstract fun playerDao():PlayerDao
}
