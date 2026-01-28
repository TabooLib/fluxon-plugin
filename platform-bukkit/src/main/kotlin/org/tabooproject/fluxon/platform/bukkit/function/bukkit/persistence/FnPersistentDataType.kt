package org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence

import org.bukkit.persistence.PersistentDataAdapterContext
import org.bukkit.persistence.PersistentDataType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.persistence.PersistentDataType"])
@PlatformSide(Platform.BUKKIT)
object FnPersistentDataType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataType::class.java)
                .function("primitiveType", returnsObject().noParams()) { it.setReturnRef(it.target?.primitiveType) }
                .function("complexType", returnsObject().noParams()) { it.setReturnRef(it.target?.complexType) }
                .function("toPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef((it.target as? PersistentDataType<Any, Any>)?.toPrimitive(
                        it.getRef(0)!!,
                        it.getRef(1) as PersistentDataAdapterContext
                    ))
                }
                .function("fromPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef((it.target as? PersistentDataType<Any, Any>)?.fromPrimitive(
                        it.getRef(0)!!,
                        it.getRef(1) as PersistentDataAdapterContext
                    ))
                }
        }
    }
}

@Requires(classes = ["org.bukkit.persistence.PersistentDataType.PrimitivePersistentDataType"])
@PlatformSide(Platform.BUKKIT)
object FnPersistentDataTypePrimitivePersistentDataType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataType.PrimitivePersistentDataType::class.java)
                .function("primitiveType", returnsObject().noParams()) { it.setReturnRef(it.target?.primitiveType) }
                .function("complexType", returnsObject().noParams()) { it.setReturnRef(it.target?.complexType) }
                .function("toPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef((it.target as? PersistentDataType<Any, Any>)?.toPrimitive(
                        it.getRef(0)!!,
                        it.getRef(1) as PersistentDataAdapterContext
                    ))
                }
                .function("fromPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef((it.target as? PersistentDataType<Any, Any>)?.fromPrimitive(
                        it.getRef(0)!!,
                        it.getRef(1) as PersistentDataAdapterContext
                    ))
                }
        }
    }
}

@Requires(classes = ["org.bukkit.persistence.PersistentDataType.BooleanPersistentDataType"])
@PlatformSide(Platform.BUKKIT)
object FnPersistentDataTypeBooleanPersistentDataType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataType.BooleanPersistentDataType::class.java)
                .function("primitiveType", returnsObject().noParams()) { it.setReturnRef(it.target?.primitiveType) }
                .function("complexType", returnsObject().noParams()) { it.setReturnRef(it.target?.complexType) }
                .function("toPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef((it.target as? PersistentDataType<Byte, Boolean>)?.toPrimitive(
                        it.getBool(0),
                        it.getRef(1) as PersistentDataAdapterContext
                    ))
                }
                .function("fromPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef((it.target as? PersistentDataType<Byte, Boolean>)?.fromPrimitive(
                        it.getRef(0) as Byte,
                        it.getRef(1) as PersistentDataAdapterContext
                    ))
                }
        }
    }
}
