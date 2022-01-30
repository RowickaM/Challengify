package pl.gungnir.challengify.data.model

data class EventShort(
    val id: String,
    val title: String,
    val type: EventType,
    val progress: String,
    val isDone: Boolean
)
