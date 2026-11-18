package com.example.qlsvien_project

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StudentListScreen(onAddStudent: () -> Unit, onDetailClick: () -> Unit, onTransferRoom: () -> Unit, onEndStay: () -> Unit) {
    val students = listOf(
        Triple("Nguyễn Minh Anh", "MSSV: 22110345 • A-101 - Giường 01", "Sắp hết hạn"),
        Triple("Trần Ngọc Mai", "MSSV: 22110402 • A-102 - Giường 03", "Đang lưu trú"),
        Triple("Lê Thu Hà", "MSSV: 22110518 • A-103 - Giường 02", "Đang lưu trú"),
        Triple("Võ Quốc Tuấn", "MSSV: 22110218 • B-201 - Giường 01", "Sắp hết hạn")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Quản lý sinh viên", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Button(onClick = onAddStudent, contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)) {
                Icon(Icons.Default.Add, null, modifier = Modifier.size(16.dp))
                Spacer(Modifier.width(4.dp))
                Text("Thêm sinh viên", fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Tìm tên sinh viên hoặc MSSV...", fontSize = 13.sp) },
            leadingIcon = { Icon(Icons.Default.Search, null) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(students) { (name, info, status) ->
                Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(12.dp)) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(name, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            val isWarning = status == "Sắp hết hạn"
                            Surface(
                                color = if (isWarning) Color(0xFFFFF3E0) else Color(0xFFE8F5E9),
                                shape = RoundedCornerShape(6.dp)
                            ) {
                                Text(
                                    status,
                                    color = if (isWarning) Color(0xFFE65100) else Color(0xFF2E7D32),
                                    fontSize = 11.sp,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(info, fontSize = 12.sp, color = Color.Gray, modifier = Modifier.padding(vertical = 4.dp))
                        HorizontalDivider(modifier = Modifier.padding(vertical = 6.dp), color = Color(0xFFEEEEEE))
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Xem hồ sơ", color = Color(0xFF1976D2), fontSize = 12.sp, fontWeight = FontWeight.Medium, modifier = Modifier.clickable { onDetailClick() })
                            Text("Chuyển phòng", color = Color(0xFF00796B), fontSize = 12.sp, fontWeight = FontWeight.Medium, modifier = Modifier.clickable { onTransferRoom() })
                            Text("Kết thúc", color = Color.Red, fontSize = 12.sp, fontWeight = FontWeight.Medium, modifier = Modifier.clickable { onEndStay() })
                        }
                    }
                }
            }
        }
    }
}