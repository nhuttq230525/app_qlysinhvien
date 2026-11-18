package com.example.qlsvien_project

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OverviewScreen(onNavigateToFinance: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Xin chào, Hoàng Nam", fontSize = 12.sp, color = Color.Gray)
                Text("Tổng quan ký túc xá", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Surface(shape = CircleShape, color = Color(0xFFE3F2FD), modifier = Modifier.size(40.dp)) {
                Box(contentAlignment = Alignment.Center) {
                    Text("HN", fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
                }
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatBox("640", "Tổng sinh viên", Icons.Default.Person, Color(0xFF1976D2), Modifier.weight(1f))
            StatBox("120", "Tổng phòng", Icons.Default.Home, Color(0xFF388E3C), Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatBox("8", "Giường trống", Icons.Default.CheckCircle, Color(0xFFF57C00), Modifier.weight(1f))
            StatBox("90", "Phòng đang ở", Icons.Default.DateRange, Color(0xFF7B1FA2), Modifier.weight(1f))
        }

        Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(12.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Doanh thu hàng tháng", fontWeight = FontWeight.SemiBold)
                    Text("2026", color = Color(0xFF1976D2), fontSize = 12.sp)
                }
                Text("384 triệu đ", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth().height(90.dp).padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom
                ) {
                    listOf("T7" to 0.45f, "T8" to 0.6f, "T9" to 0.55f, "T10" to 0.8f, "T11" to 0.9f, "T12" to 1f).forEach { (m, h) ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Box(
                                modifier = Modifier
                                    .width(22.dp)
                                    .fillMaxHeight(h * 0.8f)
                                    .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                                    .background(if (m == "T12") Color(0xFF1976D2) else Color(0xFFBBDEFB))
                            )
                            Text(m, fontSize = 10.sp, color = Color.Gray)
                        }
                    }
                }
            }
        }

        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().clickable { onNavigateToFinance() }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("⚠️ 12 hóa đơn chưa thanh toán", fontWeight = FontWeight.Bold, color = Color(0xFFD32F2F))
                    Text("Xem chi tiết >", fontSize = 12.sp, color = Color(0xFFD32F2F))
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("Tổng công nợ: 12.450.000 đ", fontSize = 13.sp, color = Color.DarkGray)
            }
        }
    }
}

@Composable
fun StatBox(value: String, label: String, icon: ImageVector, color: Color, modifier: Modifier = Modifier) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(12.dp), modifier = modifier) {
        Row(modifier = Modifier.padding(14.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(value, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(label, fontSize = 12.sp, color = Color.Gray)
            }
            Icon(icon, null, tint = color)
        }
    }
}