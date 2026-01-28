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
                .function("bytes", returnsObject().noParams()) { it.target?.bytes() }
                .function("shorts", returnsObject().noParams()) { it.target?.shorts() }
                .function("integers", returnsObject().noParams()) { it.target?.integers() }
                .function("longs", returnsObject().noParams()) { it.target?.longs() }
                .function("floats", returnsObject().noParams()) { it.target?.floats() }
                .function("doubles", returnsObject().noParams()) { it.target?.doubles() }
                .function("booleans", returnsObject().noParams()) { it.target?.booleans() }
                .function("strings", returnsObject().noParams()) { it.target?.strings() }
                .function("byteArrays", returnsObject().noParams()) { it.target?.byteArrays() }
                .function("integerArrays", returnsObject().noParams()) { it.target?.integerArrays() }
                .function("longArrays", returnsObject().noParams()) { it.target?.longArrays() }
                .function("dataContainers", returnsObject().noParams()) { it.target?.dataContainers() }
                .function("listTypeFrom", returnsObject().params(Type.OBJECT)) { it.target?.listTypeFrom(it.getRef(0) as PersistentDataType<Any, Any>) }

//            registerExtension(ListPersistentDataTypeProvider.ListPersistentDataTypeImpl::class.java)
//                .function("primitiveType", returnsObject().noParams()) { it.target?.getPrimitiveType() }
//                .function("complexType", returnsObject().noParams()) { it.target?.getComplexType() }
//                .function("toPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
//                    (it.target as ListPersistentDataTypeProvider.ListPersistentDataTypeImpl<Any, Any>)?.toPrimitive(
//                        it.getRef(0) as List<Any>,
//                        it.getRef(1) as PersistentDataAdapterContext
//                    )
//                }
//                .function("fromPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
//                    (it.target as ListPersistentDataTypeProvider.ListPersistentDataTypeImpl<Any, Any>)?.fromPrimitive(
//                        it.getRef(0) as List<Any>,
//                        it.getRef(1) as PersistentDataAdapterContext
//                    )
//                }
        }
    }
}
