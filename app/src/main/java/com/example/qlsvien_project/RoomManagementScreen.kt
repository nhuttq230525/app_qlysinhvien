package com.example.qlsvien_project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoomManagementScreen() {
    var selectedBuilding by remember { mutableStateOf("Tất cả") }
    val rooms = listOf(
        Triple("A-101", "4/4 giường", "Đã đầy"),
        Triple("A-102", "3/4 giường", "Còn chỗ"),
        Triple("A-103", "2/4 giường", "Còn chỗ"),
        Triple("B-201", "4/4 giường", "Đã đầy"),
        Triple("B-202", "1/4 giường", "Còn chỗ"),
        Triple("C-301", "3/4 giường", "Còn chỗ")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Quản lý phòng ở", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("Tất cả", "Tòa A", "Tòa B", "Tòa C").forEach { building ->
                FilterChip(
                    selected = selectedBuilding == building,
                    onClick = { selectedBuilding = building },
                    label = { Text(building, fontSize = 12.sp) }
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.weight(1f).verticalScroll(rememberScrollState())) {
            rooms.chunked(2).forEach { rowRooms ->
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    rowRooms.forEach { (roomName, beds, status) ->
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Text(roomName, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                Text(beds, fontSize = 12.sp, color = Color.Gray)
                                Spacer(modifier = Modifier.height(8.dp))
                                val isFull = status == "Đã đầy"
                                Surface(
                                    color = if (isFull) Color(0xFFFFEBEE) else Color(0xFFE8F5E9),
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text(
                                        status,
                                        color = if (isFull) Color.Red else Color(0xFF2E7D32),
                                        fontSize = 11.sp,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text("+ Thêm phòng mới")
        }
    }
}