package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Spellcaster\$Spell"])
@PlatformSide(Platform.BUKKIT)
object FnSpellcasterSpell : FnEnumGetter<org.bukkit.entity.Spellcaster.Spell>() {

    override val enumClass: Class<org.bukkit.entity.Spellcaster.Spell> = org.bukkit.entity.Spellcaster.Spell::class.java
}
