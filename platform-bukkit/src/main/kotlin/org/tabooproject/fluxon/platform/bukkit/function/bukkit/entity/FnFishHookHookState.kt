package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.FishHook\$HookState"])
@PlatformSide(Platform.BUKKIT)
object FnFishHookHookState : FnEnumGetter<org.bukkit.entity.FishHook.HookState>() {

    override val enumClass: Class<org.bukkit.entity.FishHook.HookState> = org.bukkit.entity.FishHook.HookState::class.java
}
