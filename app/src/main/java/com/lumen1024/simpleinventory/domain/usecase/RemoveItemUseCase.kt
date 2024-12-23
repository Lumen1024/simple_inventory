package com.lumen1024.simpleinventory.domain.usecase

import com.lumen1024.simpleinventory.domain.repository.ItemRepository
import javax.inject.Inject

class RemoveItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {

    suspend operator fun invoke(id: String) {
        itemRepository.removeItem(id)
    }
}