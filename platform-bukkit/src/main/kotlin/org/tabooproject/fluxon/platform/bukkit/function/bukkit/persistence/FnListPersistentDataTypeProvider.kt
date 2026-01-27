package org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence

import org.bukkit.persistence.ListPersistentDataTypeProvider
import org.bukkit.persistence.PersistentDataType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.persistence.ListPersistentDataTypeProvider"])
@PlatformSide(Platform.BUKKIT)
object FnListPersistentDataTypeProvider {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ListPersistentDataTypeProvider::class.java)
                .function("bytes", 0) { it.target?.bytes() }
                .function("shorts", 0) { it.target?.shorts() }
                .function("integers", 0) { it.target?.integers() }
                .function("longs", 0) { it.target?.longs() }
                .function("floats", 0) { it.target?.floats() }
                .function("doubles", 0) { it.target?.doubles() }
                .function("booleans", 0) { it.target?.booleans() }
                .function("strings", 0) { it.target?.strings() }
                .function("byteArrays", 0) { it.target?.byteArrays() }
                .function("integerArrays", 0) { it.target?.integerArrays() }
                .function("longArrays", 0) { it.target?.longArrays() }
                .function("dataContainers", 0) { it.target?.dataContainers() }
                .function(
                    "listTypeFrom",
                    1
                ) { it.target?.listTypeFrom(it.getArgument(0) as PersistentDataType<Any, Any>) }

//            registerExtension(ListPersistentDataTypeProvider.ListPersistentDataTypeImpl::class.java)
//                .function("primitiveType", 0) { it.target?.getPrimitiveType() }
//                .function("complexType", 0) { it.target?.getComplexType() }
//                .function("toPrimitive", 2) {
//                    (it.target as ListPersistentDataTypeProvider.ListPersistentDataTypeImpl<Any, Any>)?.toPrimitive(
//                        it.getArgument(0) as List<Any>,
//                        it.getArgument(1) as PersistentDataAdapterContext
//                    )
//                }
//                .function("fromPrimitive", 2) {
//                    (it.target as ListPersistentDataTypeProvider.ListPersistentDataTypeImpl<Any, Any>)?.fromPrimitive(
//                        it.getArgument(0) as List<Any>,
//                        it.getArgument(1) as PersistentDataAdapterContext
//                    )
//                }
        }
    }
}
