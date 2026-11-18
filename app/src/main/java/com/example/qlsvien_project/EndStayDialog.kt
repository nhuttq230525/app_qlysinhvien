package com.example.qlsvien_project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EndStayDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Kết thúc lưu trú", fontWeight = FontWeight.Bold) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Sinh viên: Nguyễn Minh Anh (MSSV: 22110345)")
                Text("Phòng: Tòa A - A-101 - Giường 01")
                HorizontalDivider()
                Text("ĐỐI SOÁT TÀI CHÍNH:", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                Text("• Nợ tiền phòng tháng 11: 1.200.000 đ", color = Color.Red, fontSize = 12.sp)
                Text("• Điện, nước: 180.000 đ", fontSize = 12.sp)
                Text("• Hoàn cọc dự kiến: 1.500.000 đ", color = Color(0xFF2E7D32), fontSize = 12.sp)
                Text("⚠️ Xác nhận kết thúc lưu trú, hồ sơ và lịch sử thanh toán được giữ nguyên.", fontSize = 11.sp, color = Color.Gray)
            }
        },
        confirmButton = {
            Button(
                onClick = onConfirm,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Xác nhận kết thúc")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Hủy")
            }
        }
    )
}