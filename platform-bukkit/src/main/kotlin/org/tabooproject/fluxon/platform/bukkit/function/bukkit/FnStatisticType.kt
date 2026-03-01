package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Statistic
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.Statistic\$Type"])
@PlatformSide(Platform.BUKKIT)
object FnStatisticType : FnEnumGetter<Statistic.Type>() {

    override val enumClass: Class<Statistic.Type> = Statistic.Type::class.java
}
