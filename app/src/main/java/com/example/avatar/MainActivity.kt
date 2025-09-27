package com.example.avatar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AvatarApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvatarApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AvatarApp", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFF1493) // Pink Fanta
                )
            )
        }
    ) { innerPadding ->
        AvatarScreen(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color(0xFFFFD1DC)) // Pink Pastel
        )
    }
}

@Composable
fun AvatarScreen(modifier: Modifier = Modifier) {
    var showBrow by remember { mutableStateOf(true) }
    var showEye by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Avatar Area
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            // Base Face
            Image(
                painter = painterResource(id = R.drawable.face_0004),
                contentDescription = "Base Face",
                modifier = Modifier.wrapContentSize()
            )

            if (showBrow) {
                Image(
                    painter = painterResource(id = R.drawable.face_0001),
                    contentDescription = "Brow",
                    modifier = Modifier
                        .wrapContentSize()
                        .offset(y = (-40).dp)
                )
            }

            if (showEye) {
                Image(
                    painter = painterResource(id = R.drawable.face_0003),
                    contentDescription = "Eye",
                    modifier = Modifier
                        .wrapContentSize()
                        .scale(0.9f)
                        .offset(y = 0.dp)
                )
            }

            if (showNose) {
                Image(
                    painter = painterResource(id = R.drawable.face_0002),
                    contentDescription = "Nose",
                    modifier = Modifier
                        .wrapContentSize()
                        .offset(y = (45).dp)
                        .scale(0.8f)
                )
            }

            if (showMouth) {
                Image(
                    painter = painterResource(id = R.drawable.face_0000),
                    contentDescription = "Mouth",
                    modifier = Modifier
                        .wrapContentSize()
                        .offset(y = (90).dp)
                )
            }
        }

        // Checkbox Controls
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = showBrow,
                        onCheckedChange = { showBrow = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFFFF9800),
                            uncheckedColor = Color(0xFFFF9800),
                            checkmarkColor = Color.White
                        )
                    )
                    Text("Brow", fontSize = 12.sp)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = showEye,
                        onCheckedChange = { showEye = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFFFF9800),
                            uncheckedColor = Color(0xFFFF9800),
                            checkmarkColor = Color.White
                        )
                    )
                    Text("Eye", fontSize = 12.sp)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = showNose,
                        onCheckedChange = { showNose = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFFFF9800),
                            uncheckedColor = Color(0xFFFF9800),
                            checkmarkColor = Color.White
                        )
                    )
                    Text("Nose", fontSize = 12.sp)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = showMouth,
                        onCheckedChange = { showMouth = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFFFF9800),
                            uncheckedColor = Color(0xFFFF9800),
                            checkmarkColor = Color.White
                        )
                    )
                    Text("Mouth", fontSize = 12.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAvatarApp() {
    AvatarApp()
}
