package com.example.qlsvien_project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
fun AddStudentScreen(onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Thêm hồ sơ sinh viên", fontSize = 18.sp, fontWeight = FontWeight.Bold) },
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
            Text("1. Thông tin cá nhân", fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
            OutlinedTextField(value = "24110782", onValueChange = {}, label = { Text("Mã số sinh viên *") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = "Phạm Thảo Vy", onValueChange = {}, label = { Text("Họ và tên *") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = "Công nghệ thông tin - K24", onValueChange = {}, label = { Text("Ngành / Lớp") }, modifier = Modifier.fillMaxWidth())

            Text("2. Bố trí phòng ở", fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
            OutlinedTextField(value = "Tòa A - Tầng 1", onValueChange = {}, label = { Text("Tòa nhà / Tầng") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = "Phòng A-101 - Giường 03", onValueChange = {}, label = { Text("Phòng & Giường") }, modifier = Modifier.fillMaxWidth())

            Text("3. Hợp đồng lưu trú", fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
            OutlinedTextField(value = "1.500.000 đ", onValueChange = {}, label = { Text("Tiền đặt cọc") }, modifier = Modifier.fillMaxWidth())
        }
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("✓ Lưu sinh viên")
        }
    }
}