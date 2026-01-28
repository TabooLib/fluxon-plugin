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
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.persistence.ListPersistentDataTypeProvider"])
@PlatformSide(Platform.BUKKIT)
object FnListPersistentDataTypeProvider {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ListPersistentDataTypeProvider::class.java)
                .function("bytes", returnsObject().noParams()) { it.setReturnRef(it.target?.bytes()) }
                .function("shorts", returnsObject().noParams()) { it.setReturnRef(it.target?.shorts()) }
                .function("integers", returnsObject().noParams()) { it.setReturnRef(it.target?.integers()) }
                .function("longs", returnsObject().noParams()) { it.setReturnRef(it.target?.longs()) }
                .function("floats", returnsObject().noParams()) { it.setReturnRef(it.target?.floats()) }
                .function("doubles", returnsObject().noParams()) { it.setReturnRef(it.target?.doubles()) }
                .function("booleans", returnsObject().noParams()) { it.setReturnRef(it.target?.booleans()) }
                .function("strings", returnsObject().noParams()) { it.setReturnRef(it.target?.strings()) }
                .function("byteArrays", returnsObject().noParams()) { it.setReturnRef(it.target?.byteArrays()) }
                .function("integerArrays", returnsObject().noParams()) { it.setReturnRef(it.target?.integerArrays()) }
                .function("longArrays", returnsObject().noParams()) { it.setReturnRef(it.target?.longArrays()) }
                .function("dataContainers", returnsObject().noParams()) { it.setReturnRef(it.target?.dataContainers()) }
                .function("listTypeFrom", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.listTypeFrom(it.getRef(0) as PersistentDataType<Any, Any>)) }

//            registerExtension(ListPersistentDataTypeProvider.ListPersistentDataTypeImpl::class.java)
//                .function("primitiveType", returnsObject().noParams()) { it.setReturnRef(it.target?.getPrimitiveType()) }
//                .function("complexType", returnsObject().noParams()) { it.setReturnRef(it.target?.getComplexType()) }
//                .function("toPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
//                    it.setReturnRef((it.target as ListPersistentDataTypeProvider.ListPersistentDataTypeImpl<Any, Any>)?.toPrimitive(
//                        it.getRef(0) as List<Any>,
//                        it.getRef(1) as PersistentDataAdapterContext
//                    ))
//                }
//                .function("fromPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
//                    it.setReturnRef((it.target as ListPersistentDataTypeProvider.ListPersistentDataTypeImpl<Any, Any>)?.fromPrimitive(
//                        it.getRef(0) as List<Any>,
//                        it.getRef(1) as PersistentDataAdapterContext
//                    ))
//                }
        }
    }
}
