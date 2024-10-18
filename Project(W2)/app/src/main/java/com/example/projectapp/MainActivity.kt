package com.example.projectapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import com.example.projectapp.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectapp.ui.theme.ProjectAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DishCard()
                }
            }
        }
    }
}

@Composable
fun DishCard(modifier: Modifier = Modifier) {

    // State to track the currently selected dish
    var selectedDish by remember { mutableStateOf(Dish.Tanjia) }

    // Update the content based on the selected dish
    val dishContent = when (selectedDish) {
        Dish.Tanjia -> DishContent(
            imageRes = R.drawable.tanjia,
            title = "Tanjia",
            region = "Popular Region: Marrakech, Morocco",
            description = "Tanjia is a traditional slow-cooked Moroccan dish, made in a special clay pot over hot coals...",
            prepTime = "Preparation Time: 6-8 hours",
            ingredients = "• Beef\n• Preserved lemon\n• Garlic\n• Cumin\n• Olive oil\n• Saffron\n• Ras el Hanout"
        )
        Dish.Tagine -> DishContent(
            imageRes = R.drawable.tagine,
            title = "Tagine",
            region = "Popular Region: Morocco",
            description = "Tagine is a traditional North African dish named after the pot in which it is cooked...",
            prepTime = "Preparation Time: 2-4 hours",
            ingredients = "• Lamb or Chicken\n• Dried Fruits\n• Spices\n• Olive oil\n• Almonds\n• Saffron"
        )
        Dish.Couscous -> DishContent(
            imageRes = R.drawable.couscous,
            title = "Couscous",
            region = "Popular Region: North Africa",
            description = "Couscous is a traditional North African dish of steamed semolina served with stew...",
            prepTime = "Preparation Time: 1-2 hours",
            ingredients = "• Semolina\n• Vegetables\n• Meat\n• Spices\n• Olive oil"
        )
    }

    // Background image
    val backgroundImage = painterResource(R.drawable.blurtanj)

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        // Background image
        Image(
            painter = backgroundImage,
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        ) {
            // Display the selected dish image and content
            Image(
                painter = painterResource(dishContent.imageRes),
                contentDescription = "Image of ${dishContent.title}",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .heightIn(max = 200.dp)
                    .border(width = 4.dp, color = Color.White, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = dishContent.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF3C623)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = dishContent.region,
                fontSize = 16.sp,
                color = Color(0xFFF3C623)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = dishContent.description,
                fontSize = 14.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = dishContent.prepTime,
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Main Ingredients:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF3C623)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = dishContent.ingredients,
                fontSize = 14.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Buttons to switch between dishes
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Button with Yellow background and White text
                Button(
                    onClick = { selectedDish = Dish.Tanjia },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF3C623), // Yellow background color
                        contentColor = Color.White // White text color
                    )
                ) {
                    Text(text = "Tanjia")
                }

                // Button with Orange background and White text
                Button(
                    onClick = { selectedDish = Dish.Tagine },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF5722), // Orange background color
                        contentColor = Color.White // White text color
                    )
                ) {
                    Text(text = "Tagine")
                }

                // Button with Yellow background and White text
                Button(
                    onClick = { selectedDish = Dish.Couscous },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF3C623), // Yellow background color
                        contentColor = Color.White // White text color
                    )
                ) {
                    Text(text = "Couscous")
                }
            }

        }
    }
}

// Enum to represent the dishes
enum class Dish {
    Tanjia, Tagine, Couscous
}

// Data class to hold dish content
data class DishContent(
    val imageRes: Int,
    val title: String,
    val region: String,
    val description: String,
    val prepTime: String,
    val ingredients: String
)

@Preview(showBackground = true)
@Composable
fun ProjectAppPreview() {
    ProjectAppTheme {
        DishCard()
    }
}