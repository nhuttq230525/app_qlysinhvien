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
fun StayTimelineScreen(onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Quá trình lưu trú", fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, null) }
            }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(12.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Đặng Ngọc Hân • MSSV: 22110452 - Tòa A", fontWeight = FontWeight.Bold)
                    Text("Dòng thời gian lưu trú chi tiết", fontSize = 12.sp, color = Color.Gray)
                }
            }

            val milestones = listOf(
                "01/09/2025 - 31/01/2027: Nhận phòng A-101 (Giường 01)",
                "15/10/2025: Yêu cầu chuyển phòng sang A-104",
                "30/11/2025: Gia hạn hợp đồng lưu trú thêm 6 tháng",
                "03/11/2026: Dự kiến kết thúc lưu trú"
            )

            milestones.forEach { event ->
                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F7FA)), shape = RoundedCornerShape(8.dp)) {
                    Text(text = "• $event", fontSize = 13.sp, modifier = Modifier.padding(14.dp), color = Color.DarkGray)
                }
            }
        }
    }
}