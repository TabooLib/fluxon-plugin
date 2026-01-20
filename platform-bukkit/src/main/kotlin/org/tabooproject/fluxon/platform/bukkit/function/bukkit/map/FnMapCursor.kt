package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapCursor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMapCursor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapCursor::class.java)
                .function("x", 0) { it.target?.x }
                .function("y", 0) { it.target?.y }
                .function("direction", 0) { it.target?.direction }
                .function("type", 0) { it.target?.type }
                .function("rawType", 0) { it.target?.rawType }
                .function("isVisible", 0) { it.target?.isVisible }
                .function("setX", 1) { it.target?.setX(it.getNumber(0).toByte()) }
                .function("setY", 1) { it.target?.setY(it.getNumber(0).toByte()) }
                .function("setDirection", 1) { it.target?.setDirection(it.getNumber(0).toByte()) }
                .function("setType", 1) { it.target?.setType(it.getArgument(0) as MapCursor.Type) }
                .function("setRawType", 1) { it.target?.setRawType(it.getNumber(0).toByte()) }
                .function("setVisible", 1) { it.target?.setVisible(it.getBoolean(0)) }
                .function("caption", 0) { it.target?.caption }
                .function("setCaption", 1) { it.target?.setCaption(it.getString(0)) }

            registerExtension(MapCursor.Type::class.java)
                .function("key", 0) { it.target?.key }
                .function("value", 0) { it.target?.value }
                // static
                .function("byValue", 1) { MapCursor.Type.byValue(it.getNumber(0).toByte()) }
        }
    }
}
