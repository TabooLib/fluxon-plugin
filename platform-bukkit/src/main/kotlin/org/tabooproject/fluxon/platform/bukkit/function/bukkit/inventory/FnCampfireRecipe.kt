package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.CampfireRecipe
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.CampfireRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnCampfireRecipe {

    val TYPE = Type.fromClass(CampfireRecipe::class.java)
}