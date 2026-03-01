package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.recipe

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.recipe.CookingBookCategory"])
@PlatformSide(Platform.BUKKIT)
object FnCookingBookCategory : FnEnumGetter<org.bukkit.inventory.recipe.CookingBookCategory>() {

    override val enumClass: Class<org.bukkit.inventory.recipe.CookingBookCategory> = org.bukkit.inventory.recipe.CookingBookCategory::class.java
}
