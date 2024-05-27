package interface_components.tabs

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import interface_components.textColor
import scraper.Restaurant
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import interface_components.errorColor
import scraper.Menu
import util.ValidityUtil

@Composable
fun AddRestaurant(restaurants: MutableState<List<Restaurant>>) {
    var restaurantName by remember { mutableStateOf("") }
    var fullPrice by remember { mutableStateOf("0.0") }
    var payPrice by remember { mutableStateOf("0.0") }
    var longitude by remember { mutableStateOf("0.0") }
    var latitude by remember { mutableStateOf("0.0") }
    var address by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var workingTimes: List<String> by remember { mutableStateOf(listOf("")) }
    val menuList: MutableList<Menu> by remember { mutableStateOf(mutableListOf(Menu())) }

    var isValid by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val state = rememberLazyListState()

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.6f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            state = state
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Add Restaurant",
                        style = TextStyle(fontSize = 22.sp),
                        color = textColor
                    )

                    TextField(
                        value = restaurantName,
                        onValueChange = { restaurantName = it },
                        label = { Text("Restaurant Name") },
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = textColor),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = textColor.copy(alpha = 0.3f),
                            focusedLabelColor = textColor,
                            unfocusedLabelColor = textColor.copy(alpha = 0.75f)
                        )
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextField(
                            value = fullPrice,
                            onValueChange = {fullPrice = it },
                            label = { Text("Full Price") },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f),
                            textStyle = TextStyle(color = textColor),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = textColor.copy(alpha = 0.3f),
                                focusedLabelColor = textColor,
                                unfocusedLabelColor = textColor.copy(alpha = 0.75f)
                            )
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        TextField(
                            value = payPrice,
                            onValueChange = {payPrice = it },
                            label = { Text("Pay Price") },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f),
                            textStyle = TextStyle(color = textColor),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = textColor.copy(alpha = 0.3f),
                                focusedLabelColor = textColor,
                                unfocusedLabelColor = textColor.copy(alpha = 0.75f)
                            )
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextField(
                            value = latitude,
                            onValueChange = {latitude = it },
                            label = { Text("Latitude") },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f),
                            textStyle = TextStyle(color = textColor),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = textColor.copy(alpha = 0.3f),
                                focusedLabelColor = textColor,
                                unfocusedLabelColor = textColor.copy(alpha = 0.75f)
                            )
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        TextField(
                            value = longitude,
                            onValueChange = {longitude = it },
                            label = { Text("Longitude") },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f),
                            textStyle = TextStyle(color = textColor),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = textColor.copy(alpha = 0.3f),
                                focusedLabelColor = textColor,
                                unfocusedLabelColor = textColor.copy(alpha = 0.75f)
                            )
                        )
                    }

                    TextField(
                        value = address,
                        onValueChange = {address = it },
                        label = { Text("Address") },
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = textColor),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = textColor.copy(alpha = 0.3f),
                            focusedLabelColor = textColor,
                            unfocusedLabelColor = textColor.copy(alpha = 0.75f)
                        )
                    )

                    TextField(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        label = { Text("Phone Number") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = textColor),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = textColor.copy(alpha = 0.3f),
                            focusedLabelColor = textColor,
                            unfocusedLabelColor = textColor.copy(alpha = 0.75f)
                        )
                    )

                    TextField(
                        value = workingTimes.joinToString(", "),
                        onValueChange = { workingTimes = it.split(",") },
                        label = { Text("Working Times") },
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = textColor),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = textColor.copy(alpha = 0.3f),
                            focusedLabelColor = textColor,
                            unfocusedLabelColor = textColor.copy(alpha = 0.75f)
                        )
                    )

                    if (!isValid) {
                        Text(
                            text = "Input fields are not valid!",
                            style = TextStyle(fontSize = 14.sp),
                            color = errorColor
                        )
                    }

                    // TextFields for menu items
                    LazyColumn {
                        itemsIndexed(menuList) { index, menu ->
                            MenuInputFields(
                                menu = menu,
                                onMenuChange = { newMenu ->
                                    menuList[index] = newMenu
                                },
                                onDeleteMenu = {
                                    menuList.removeAt(index)
                                }
                            )
                        }
                    }

                    // Plus icon to add another menu
                    IconButton(
                        onClick = {
                            menuList.add(Menu())
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Add Menu")
                    }

                    Button(onClick = {
                        if(
                            restaurantName.length > 0 &&
                            fullPrice.toFloatOrNull() != null &&
                            payPrice.toFloatOrNull() != null &&
                            longitude.toFloatOrNull() != null &&
                            latitude.toFloatOrNull() != null &&
                            address.length > 0 &&
                            phoneNumber.length > 0 &&
                            ValidityUtil.isValidPhoneNumber(phoneNumber) &&
                            workingTimes.size > 0 &&
                            ValidityUtil.isValidWorkingHours(workingTimes.joinToString("\n"))
                        ) {
                            isValid = true
                            val restaurant = Restaurant(
                                name = restaurantName,
                                fullPrice = (fullPrice.toFloatOrNull() ?: 0.0f).toString(),
                                payPrice = (payPrice.toFloatOrNull() ?: 0.0f).toString(),
                                longitude = longitude,
                                latitude = latitude,
                                address = address,
                                phoneNumber = phoneNumber,
                                workingTimes = workingTimes.toMutableList(),
                                menuList = menuList
                            )
                            restaurants.value = restaurants.value + restaurant
                        }
                        else isValid = false
                    }) {
                        Text("Add Restaurant")
                    }
                }
            }
        }

        VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
            adapter = rememberScrollbarAdapter(
                scrollState = state
            )
        )
    }
}

@Composable
fun MenuInputFields(
    menu: Menu,
    onMenuChange: (Menu) -> Unit,
    onDeleteMenu: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = menu.dish,
            onValueChange = {  },
            label = { Text("Dish Name") },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(color = textColor),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = textColor.copy(alpha = 0.3f),
                focusedLabelColor = textColor,
                unfocusedLabelColor = textColor.copy(alpha = 0.75f)
            )
        )

        TextField(
            value = menu.category,
            onValueChange = { },
            label = { Text("Category") },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(color = textColor),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = textColor.copy(alpha = 0.3f),
                focusedLabelColor = textColor,
                unfocusedLabelColor = textColor.copy(alpha = 0.75f)
            )
        )

        TextField(
            value = menu.extras.joinToString(", "),
            onValueChange = { },
            label = { Text("Extras") },
            modifier = Modifier.fillMaxWidth()
        )

        IconButton(
            onClick = onDeleteMenu,
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(Icons.Default.Delete, contentDescription = "Delete Menu")
        }
    }
}
