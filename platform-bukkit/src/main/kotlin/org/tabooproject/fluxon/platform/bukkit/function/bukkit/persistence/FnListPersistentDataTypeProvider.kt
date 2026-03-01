package org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence

import org.bukkit.persistence.ListPersistentDataTypeProvider
import org.bukkit.persistence.PersistentDataType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.persistence.ListPersistentDataTypeProvider"])
@PlatformSide(Platform.BUKKIT)
object FnListPersistentDataTypeProvider {

    val TYPE = Type.fromClass(ListPersistentDataTypeProvider::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ListPersistentDataTypeProvider::class.java)
                .function("bytes", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.bytes()) }
                .function("shorts", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.shorts()) }
                .function("integers", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.integers()) }
                .function("longs", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.longs()) }
                .function("floats", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.floats()) }
                .function("doubles", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.doubles()) }
                .function("booleans", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.booleans()) }
                .function("strings", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.strings()) }
                .function("byteArrays", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.byteArrays()) }
                .function("integerArrays", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.integerArrays()) }
                .function("longArrays", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.longArrays()) }
                .function("dataContainers", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).noParams()) { it.setReturnRef(it.target?.dataContainers()) }
                .function("listTypeFrom",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnListPersistentDataType.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnPersistentDataType.TYPE)) { it.setReturnRef(it.target?.listTypeFrom(it.getRef(0) as PersistentDataType<Any, Any>)) }

//            registerExtension(ListPersistentDataTypeProvider.ListPersistentDataTypeImpl::class.java)
//                .function("primitiveType", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.getPrimitiveType()) }
//                .function("complexType", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.getComplexType()) }
//                .function("toPrimitive",returns(Type.OBJECT).params(Type.LIST, Type.OBJECT)) {
//                    it.setReturnRef((it.target as ListPersistentDataTypeProvider.ListPersistentDataTypeImpl<Any, Any>)?.toPrimitive(
//                        it.getRef(0) as List<Any>,
//                        it.getRef(1) as PersistentDataAdapterContext
//                    ))
//                }
//                .function("fromPrimitive", returns(Type.OBJECT).params(Type.OBJECT, Type.OBJECT)) {
//                    it.setReturnRef((it.target as ListPersistentDataTypeProvider.ListPersistentDataTypeImpl<Any, Any>)?.fromPrimitive(
//                        it.getRef(0) as List<Any>,
//                        it.getRef(1) as PersistentDataAdapterContext
//                    ))
//                }
        }
    }
}
