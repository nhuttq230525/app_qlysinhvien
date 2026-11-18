package com.example.qlsvien_project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentDetailScreen(onBack: () -> Unit, onTransferClick: () -> Unit, onTimelineClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Chi tiết sinh viên", fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, null) }
            }
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(12.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nguyễn Minh Anh", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("MSSV: 22110345 • CNTT K22", fontSize = 13.sp, color = Color.Gray)
                    Text("Phòng: A-101 (Giường 01)", fontSize = 13.sp, color = Color(0xFF1976D2))
                }
            }

            Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(12.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nơi lưu trú hiện tại", fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
                    Spacer(Modifier.height(6.dp))
                    Text("Tòa nhà: Tòa A - Tầng 1", fontSize = 13.sp)
                    Text("Phòng: A-101 / Giường 01", fontSize = 13.sp)
                    Text("Ngày nhận phòng: 01/09/2025", fontSize = 13.sp)
                    Text("Ngày hết hạn: 31/01/2027", fontSize = 13.sp)
                }
            }

            Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(12.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Lịch sử lưu trú (Timeline)", fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
                        TextButton(onClick = onTimelineClick) { Text("Xem chi tiết", fontSize = 12.sp) }
                    }
                    Spacer(Modifier.height(4.dp))
                    Text("• 01/09/2025: Nhận phòng A-101", fontSize = 13.sp)
                    Text("• 15/10/2025: Yêu cầu chuyển phòng chờ duyệt", fontSize = 13.sp)
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(onClick = {}, modifier = Modifier.weight(1f)) {
                Text("Chỉnh sửa")
            }
            Button(
                onClick = onTransferClick,
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B))
            ) {
                Text("Chuyển phòng")
            }
        }
    }
}