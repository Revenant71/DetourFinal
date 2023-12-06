package com.detour.detourfinal

sealed interface DetourEvent {
    sealed class UserEvent : DetourEvent {
        data class UserInserted(val user: User) : UserEvent()
        data class UserUpdated(val user: User) : UserEvent()
        data class UserDeleted(val user: User) : UserEvent()
    }

    sealed class ItemEvent : DetourEvent {
        data class ItemInserted(val item: Item) : ItemEvent()
        data class ItemUpdated(val item: Item) : ItemEvent()
        data class ItemDeleted(val item: Item) : ItemEvent()
    }

    object ClearAllItemsEvent : DetourEvent
}