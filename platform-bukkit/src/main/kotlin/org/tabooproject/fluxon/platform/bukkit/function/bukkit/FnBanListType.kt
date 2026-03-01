package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.BanList\$Type"])
@PlatformSide(Platform.BUKKIT)
object FnBanListType : FnEnumGetter<org.bukkit.BanList.Type>() {

    override val enumClass: Class<org.bukkit.BanList.Type> = org.bukkit.BanList.Type::class.java
}
