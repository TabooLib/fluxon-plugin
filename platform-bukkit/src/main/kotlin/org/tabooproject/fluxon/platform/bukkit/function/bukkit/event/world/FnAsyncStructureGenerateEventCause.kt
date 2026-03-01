package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.world.AsyncStructureGenerateEvent\$Cause"])
@PlatformSide(Platform.BUKKIT)
object FnAsyncStructureGenerateEventCause : FnEnumGetter<org.bukkit.event.world.AsyncStructureGenerateEvent.Cause>() {

    override val enumClass: Class<org.bukkit.event.world.AsyncStructureGenerateEvent.Cause> = org.bukkit.event.world.AsyncStructureGenerateEvent.Cause::class.java
}
