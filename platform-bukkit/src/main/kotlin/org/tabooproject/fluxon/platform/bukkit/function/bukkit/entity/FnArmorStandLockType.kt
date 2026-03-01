package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ArmorStand
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.ArmorStand\$LockType"])
@PlatformSide(Platform.BUKKIT)
object FnArmorStandLockType : FnEnumGetter<ArmorStand.LockType>() {

    override val enumClass: Class<ArmorStand.LockType> = ArmorStand.LockType::class.java
}
