package com.example.littlelemon

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerPannel(scaffoldState: ScaffoldState,scope: CoroutineScope) {
    List(5)
    {
    Text(
        text = "Home #$it",
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
    )
}
        IconButton(onClick = {
            scope.launch { scaffoldState.drawerState.close() }
        })
        {
            Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Close Icon")
        }
}