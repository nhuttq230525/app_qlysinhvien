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
fun FinanceScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Thanh toán & Hóa đơn", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(12.dp)) {
            Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                Text("Tổng thu chi tháng 10/2026", fontSize = 12.sp, color = Color.Gray)
                Text("372.000.000 đ", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
                Spacer(Modifier.height(8.dp))
                Text("Hóa đơn chưa thanh toán: 12.450.000 đ", fontSize = 13.sp, color = Color.Red)
                Text("Đã thanh toán: 628 hóa đơn", fontSize = 12.sp, color = Color.Gray)
            }
        }

        Text("Danh sách hóa đơn gần nhất", fontWeight = FontWeight.Bold)
        Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(12.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("HD-2610-0345", fontWeight = FontWeight.Bold)
                    Surface(color = Color(0xFFE8F5E9), shape = RoundedCornerShape(4.dp)) {
                        Text("Đã thanh toán", color = Color(0xFF2E7D32), fontSize = 10.sp, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                    }
                }
                Text("Nguyễn Minh Anh • A-101", fontSize = 13.sp, color = Color.Gray)
                Spacer(Modifier.height(4.dp))
                Text("Tổng tiền: 1.380.000 đ", fontSize = 13.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
}