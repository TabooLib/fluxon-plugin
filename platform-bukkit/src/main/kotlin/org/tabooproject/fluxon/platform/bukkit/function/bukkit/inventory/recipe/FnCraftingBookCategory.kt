package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.recipe

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.recipe.CraftingBookCategory"])
@PlatformSide(Platform.BUKKIT)
object FnCraftingBookCategory : FnEnumGetter<org.bukkit.inventory.recipe.CraftingBookCategory>() {

    override val enumClass: Class<org.bukkit.inventory.recipe.CraftingBookCategory> = org.bukkit.inventory.recipe.CraftingBookCategory::class.java
}
