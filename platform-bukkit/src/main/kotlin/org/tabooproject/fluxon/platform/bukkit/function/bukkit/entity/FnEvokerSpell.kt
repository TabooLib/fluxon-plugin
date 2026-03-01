package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Evoker\$Spell"])
@PlatformSide(Platform.BUKKIT)
object FnEvokerSpell : FnEnumGetter<org.bukkit.entity.Evoker.Spell>() {

    override val enumClass: Class<org.bukkit.entity.Evoker.Spell> = org.bukkit.entity.Evoker.Spell::class.java
}
