package pl.gungnir.challengify.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable

//https://medium.com/mobile-app-development-publication/staggeredverticalgrid-of-android-jetpack-compose-fa565e5363e1
@Composable
fun StaggeredVerticalGrid(
    modifier: Modifier = Modifier,
    columns: Int,
    children: @Composable () -> Unit
) {
    LazyColumn(
        modifier = modifier,
    ) {
        item {
            Layout(
                content = children
            ) { measurables, constraints ->
                val placeableXY: MutableMap<Placeable, Pair<Int, Int>> = mutableMapOf()

                check(constraints.hasBoundedWidth) {
                    "Unbounded width not supported"
                }
                val columnWidth = constraints.maxWidth / columns
                val itemConstraints = constraints.copy(maxWidth = columnWidth)
                val colHeights = IntArray(columns) { 0 }
                val placeables = measurables.map { measurable ->
                    val column = shortestColumn(colHeights)
                    val placeable = measurable.measure(itemConstraints)
                    placeableXY[placeable] = Pair(columnWidth * column, colHeights[column])
                    colHeights[column] += placeable.height
                    placeable
                }

                val height =
                    colHeights.maxOrNull()?.coerceIn(constraints.minHeight, constraints.maxHeight)
                        ?: constraints.minHeight
                layout(
                    width = constraints.maxWidth,
                    height = height
                ) {
                    placeables.forEach { placeable ->
                        placeable.place(
                            x = placeableXY.getValue(placeable).first,
                            y = placeableXY.getValue(placeable).second
                        )
                    }
                }

            }
        }
    }
}

private fun shortestColumn(colHeights: IntArray): Int {
    var minHeight = Int.MAX_VALUE
    var column = 0
    colHeights.forEachIndexed { index, height ->
        if (height < minHeight) {
            minHeight = height
            column = index
        }
    }
    return column
}