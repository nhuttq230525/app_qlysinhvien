package com.example.qlsvien_project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TransferRoomScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Quản lý chuyển phòng", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)), modifier = Modifier.weight(1f)) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Chờ duyệt", fontSize = 12.sp, color = Color.Gray)
                    Text("2", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
                }
            }
            Spacer(Modifier.width(8.dp))
            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)), modifier = Modifier.weight(1f)) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Đã duyệt", fontSize = 12.sp, color = Color.Gray)
                    Text("3", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
                }
            }
            Spacer(Modifier.width(8.dp))
            Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE)), modifier = Modifier.weight(1f)) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Từ chối", fontSize = 12.sp, color = Color.Gray)
                    Text("1", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Red)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Danh sách yêu cầu chờ duyệt", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        Column(modifier = Modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(12.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nguyễn Minh Anh (MSSV: 22110345)", fontWeight = FontWeight.Bold)
                    Text("Chuyển từ: A-101 (Giường 01) ➔ A-104 (Giường 02)", fontSize = 13.sp, color = Color.DarkGray)
                    Text("Lý do: Gần bạn học", fontSize = 12.sp, color = Color.Gray)
                    Spacer(Modifier.height(10.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Button(onClick = {}, modifier = Modifier.weight(1f)) { Text("Duyệt") }
                        OutlinedButton(onClick = {}, modifier = Modifier.weight(1f)) { Text("Từ chối", color = Color.Red) }
                    }
                }
            }
        }
    }
}