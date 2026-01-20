package org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence

import org.bukkit.persistence.PersistentDataAdapterContext
import org.bukkit.persistence.PersistentDataType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPersistentDataType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataType::class.java)
                .function("primitiveType", 0) { it.target?.primitiveType }
                .function("complexType", 0) { it.target?.complexType }
                .function(
                    "toPrimitive",
                    2
                ) {
                    (it.target as? PersistentDataType<Any, Any>)?.toPrimitive(
                        it.getArgument(0)!!,
                        it.getArgument(1) as PersistentDataAdapterContext
                    )
                }
                .function(
                    "fromPrimitive",
                    2
                ) {
                    (it.target as? PersistentDataType<Any, Any>)?.fromPrimitive(
                        it.getArgument(0)!!,
                        it.getArgument(1) as PersistentDataAdapterContext
                    )
                }

            registerExtension(PersistentDataType.PrimitivePersistentDataType::class.java)
                .function("primitiveType", 0) { it.target?.primitiveType }
                .function("complexType", 0) { it.target?.complexType }
                .function(
                    "toPrimitive",
                    2
                ) {
                    (it.target as? PersistentDataType<Any, Any>)?.toPrimitive(
                        it.getArgument(0)!!,
                        it.getArgument(1) as PersistentDataAdapterContext
                    )
                }
                .function(
                    "fromPrimitive",
                    2
                ) {
                    (it.target as? PersistentDataType<Any, Any>)?.fromPrimitive(
                        it.getArgument(0)!!,
                        it.getArgument(1) as PersistentDataAdapterContext
                    )
                }

            registerExtension(PersistentDataType.BooleanPersistentDataType::class.java)
                .function("primitiveType", 0) { it.target?.primitiveType }
                .function("complexType", 0) { it.target?.complexType }
                .function(
                    "toPrimitive",
                    2
                ) {
                    (it.target as? PersistentDataType<Byte, Boolean>)?.toPrimitive(
                        it.getBoolean(0),
                        it.getArgument(1) as PersistentDataAdapterContext
                    )
                }
                .function(
                    "fromPrimitive",
                    2
                ) {
                    (it.target as? PersistentDataType<Byte, Boolean>)?.fromPrimitive(
                        it.getArgument(0) as Byte,
                        it.getArgument(1) as PersistentDataAdapterContext
                    )
                }
        }
    }
}
