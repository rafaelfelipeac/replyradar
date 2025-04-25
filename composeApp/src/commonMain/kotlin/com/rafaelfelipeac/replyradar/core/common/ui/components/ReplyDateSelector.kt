package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.common.clock.LocalClock
import com.rafaelfelipeac.replyradar.core.common.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.empty
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.common.ui.paddingXSmall
import com.rafaelfelipeac.replyradar.core.common.ui.replyDateItemWidth
import com.rafaelfelipeac.replyradar.core.common.ui.replyDateSelectorMaxTonalElevation
import com.rafaelfelipeac.replyradar.core.common.ui.replyDateSelectorMinTonalElevation
import kotlinx.datetime.DateTimeUnit.Companion.DAY
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime

@Composable
fun ReplyDateSelector(
    modifier: Modifier = Modifier,
    selectedDate: LocalDate?,
    onDateSelected: (LocalDate) -> Unit
) {
    val clock = LocalClock.current

    val today = remember {
        Instant.fromEpochMilliseconds(clock.now())
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .date
    }
    val dates = remember {
        (0..CALENDAR_RANGE).map { offset -> today.plus(offset, DAY) }
    }

    val listState = rememberLazyListState()
    val visibleIndex by remember {
        derivedStateOf { listState.firstVisibleItemIndex }
    }

    val currentDate = dates.getOrNull(visibleIndex)
    val currentMonthText = currentDate?.let {
        "${LocalReplyRadarStrings.current.months[currentDate.monthNumber - 1]} ${it.year}"
    }

    if (selectedDate == null && currentDate != null) {
        onDateSelected(currentDate)
    }

    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = paddingSmall, end = paddingSmall),
            text = LocalReplyRadarStrings.current.componentReplyDateSelectorLabel,
            style = typography.bodySmall
        )

        if (currentMonthText != null) {
            Surface(
                tonalElevation = replyDateSelectorMinTonalElevation,
                color = colorScheme.surface,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = paddingSmall, end = paddingSmall, top = paddingSmall),
            ) {
                Text(
                    text = currentMonthText,
                    style = typography.titleSmall,
                    modifier = Modifier
                        .padding(horizontal = paddingSmall, vertical = paddingSmall)
                )
            }
        }

        LazyRow(
            state = listState,
            horizontalArrangement = spacedBy(paddingSmall),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = paddingSmall, horizontal = paddingSmall)
        ) {
            itemsIndexed(
                items = dates,
                key = { _, item -> item.toString() }
            ) { index, date ->
                val isSelected = selectedDate == date

                Surface(
                    color = if (isSelected) colorScheme.primary else colorScheme.surfaceVariant,
                    shape = shapes.small,
                    tonalElevation = if (isSelected) replyDateSelectorMaxTonalElevation else replyDateSelectorMinTonalElevation,
                    modifier = Modifier
                        .padding(end = if (index < dates.lastIndex) paddingXSmall else empty)
                        .clickable { onDateSelected(date) }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(
                            vertical = paddingSmall,
                            horizontal = replyDateItemWidth
                        )
                    ) {
                        Text(
                            text = date.dayOfMonth.toString(),
                            style = typography.bodyLarge
                        )
                        Text(
                            text = LocalReplyRadarStrings.current.weekDaysShort[date.dayOfWeek.ordinal]
                                .replaceFirstChar { it.uppercase() },
                            style = typography.labelSmall
                        )
                    }
                }
            }
        }
    }
}

private const val CALENDAR_RANGE = 90 // 3 month range
