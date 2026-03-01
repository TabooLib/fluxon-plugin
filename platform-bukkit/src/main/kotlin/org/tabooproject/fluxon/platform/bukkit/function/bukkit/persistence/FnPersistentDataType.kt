package org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence

import org.bukkit.persistence.PersistentDataAdapterContext
import org.bukkit.persistence.PersistentDataType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.persistence.PersistentDataType"])
@PlatformSide(Platform.BUKKIT)
object FnPersistentDataType {

    val TYPE = Type.fromClass(PersistentDataType::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataType::class.java)
                .function("primitiveType",returns(Type.CLASS).noParams()) { it.setReturnRef(it.target?.primitiveType) }
                .function("complexType",returns(Type.CLASS).noParams()) { it.setReturnRef(it.target?.complexType) }
                .function("toPrimitive",returns(Type.OBJECT).params(Type.OBJECT, org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnPersistentDataAdapterContext.TYPE)) {
                    it.setReturnRef((it.target as? PersistentDataType<Any, Any>)?.toPrimitive(
                        it.getRef(0)!!,
                        it.getRef(1) as PersistentDataAdapterContext
                    ))
                }
                .function("fromPrimitive",returns(Type.OBJECT).params(Type.OBJECT, org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnPersistentDataAdapterContext.TYPE)) {
                    it.setReturnRef((it.target as? PersistentDataType<Any, Any>)?.fromPrimitive(
                        it.getRef(0)!!,
                        it.getRef(1) as PersistentDataAdapterContext
                    ))
                }
        }
    }
}

@Requires(classes = ["org.bukkit.persistence.PersistentDataType\$PrimitivePersistentDataType"])
@PlatformSide(Platform.BUKKIT)
object FnPersistentDataTypePrimitivePersistentDataType {

    val TYPE = Type.fromClass(PersistentDataType.PrimitivePersistentDataType::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataType.PrimitivePersistentDataType::class.java)
                .function("primitiveType", returns(Type.CLASS).noParams()) { it.setReturnRef(it.target?.primitiveType) }
                .function("complexType", returns(Type.CLASS).noParams()) { it.setReturnRef(it.target?.complexType) }
                .function("toPrimitive",returns(Type.OBJECT).params(Type.OBJECT, org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnPersistentDataAdapterContext.TYPE)) {
                    it.setReturnRef((it.target as? PersistentDataType<Any, Any>)?.toPrimitive(
                        it.getRef(0)!!,
                        it.getRef(1) as PersistentDataAdapterContext
                    ))
                }
                .function("fromPrimitive",returns(Type.OBJECT).params(Type.OBJECT, org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnPersistentDataAdapterContext.TYPE)) {
                    it.setReturnRef((it.target as? PersistentDataType<Any, Any>)?.fromPrimitive(
                        it.getRef(0)!!,
                        it.getRef(1) as PersistentDataAdapterContext
                    ))
                }
        }
    }
}

@Requires(classes = ["org.bukkit.persistence.PersistentDataType\$BooleanPersistentDataType"])
@PlatformSide(Platform.BUKKIT)
object FnPersistentDataTypeBooleanPersistentDataType {

    val TYPE = Type.fromClass(PersistentDataType.BooleanPersistentDataType::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataType.BooleanPersistentDataType::class.java)
                .function("primitiveType", returns(Type.CLASS).noParams()) { it.setReturnRef(it.target?.primitiveType) }
                .function("complexType", returns(Type.CLASS).noParams()) { it.setReturnRef(it.target?.complexType) }
                .function("toPrimitive", returns(Type.I).params(Type.Z, org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnPersistentDataAdapterContext.TYPE)) {
                    it.setReturnInt(((it.target as? PersistentDataType<Byte, Boolean>)?.toPrimitive(
                        it.getBool(0),
                        it.getRef(1) as PersistentDataAdapterContext
                    ) ?: 0).toInt())
                }
                .function("fromPrimitive", returns(Type.Z).params(Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnPersistentDataAdapterContext.TYPE)) {
                    it.setReturnBool((it.target as? PersistentDataType<Byte, Boolean>)?.fromPrimitive(
                        it.getInt(0).toByte(),
                        it.getRef(1) as PersistentDataAdapterContext
                    ) ?: false)
                }
        }
    }
}
