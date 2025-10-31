package com.luminteam.lumin.ui.screens.learn.theory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.ui.components.LuminMarkdownText
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.R
import com.luminteam.lumin.data.PageData
import com.luminteam.lumin.data.levels.basic.sections.SequentialExecution.Theory.SequentialExecutionTheory

@Composable
fun TheoryScreen() {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    var page by remember { mutableStateOf<PageData>(SequentialExecutionTheory.pages[0]) }

    LaunchedEffect(page) {
        lazyListState.animateScrollToItem(0)
    }

    LazyColumn(
        modifier = Modifier.padding(20.dp),
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        item {
            LuminMarkdownText(
                markdown = page.content
            )
        }

        item {
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Button(
                    onClick = {
                        if (page.pageNumber > 1) {
                            page = SequentialExecutionTheory.pages[page.pageNumber - 2]
                        }
                    },
                    contentPadding = PaddingValues(vertical = 0.dp, horizontal = 20.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painterResource(R.drawable.back_arrow_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp)
                                .rotate(180f),
                        )
                        Text(text = "Anterior")
                    }
                }
                Button(
                    onClick = {
                        if (page.pageNumber < SequentialExecutionTheory.pages.size) {
                            page = SequentialExecutionTheory.pages[page.pageNumber]
                        }
                    },
                    contentPadding = PaddingValues(vertical = 0.dp, horizontal = 20.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = "Siguiente")
                        Icon(
                            painterResource(R.drawable.back_arrow_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp),
                        )
                    }
                }
            }
        }

    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun TheoryScreenPreview() {
    LuminTheme {
        TheoryScreen()
    }
}