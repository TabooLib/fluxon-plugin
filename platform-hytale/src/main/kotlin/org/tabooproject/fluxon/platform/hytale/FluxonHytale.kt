package org.tabooproject.fluxon.platform.hytale

import taboolib.common.env.RuntimeDependencies
import taboolib.common.env.RuntimeDependency
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@RuntimeDependencies(
    RuntimeDependency("org.ow2.asm:asm:9.8"),
    RuntimeDependency("org.ow2.asm:asm-util:9.8"),
    RuntimeDependency("org.ow2.asm:asm-commons:9.8"),
)
@PlatformSide(Platform.HYTALE)
class FluxonHytale {
}