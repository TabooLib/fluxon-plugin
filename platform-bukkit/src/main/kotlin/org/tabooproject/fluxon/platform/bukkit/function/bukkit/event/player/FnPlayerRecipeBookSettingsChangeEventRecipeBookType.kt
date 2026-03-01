package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent\$RecipeBookType"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerRecipeBookSettingsChangeEventRecipeBookType : FnEnumGetter<org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent.RecipeBookType>() {

    override val enumClass: Class<org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent.RecipeBookType> = org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent.RecipeBookType::class.java
}
