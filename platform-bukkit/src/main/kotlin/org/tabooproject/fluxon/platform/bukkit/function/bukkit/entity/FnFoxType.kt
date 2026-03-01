package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Fox\$Type"])
@PlatformSide(Platform.BUKKIT)
object FnFoxType : FnEnumGetter<org.bukkit.entity.Fox.Type>() {

    override val enumClass: Class<org.bukkit.entity.Fox.Type> = org.bukkit.entity.Fox.Type::class.java
}
