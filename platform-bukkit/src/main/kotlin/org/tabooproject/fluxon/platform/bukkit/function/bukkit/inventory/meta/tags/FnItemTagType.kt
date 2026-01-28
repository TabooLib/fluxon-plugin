package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.tags

import org.bukkit.inventory.meta.tags.ItemTagAdapterContext
import org.bukkit.inventory.meta.tags.ItemTagType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.tags.ItemTagType"])
@PlatformSide(Platform.BUKKIT)
object FnItemTagType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemTagType::class.java)
                .function("primitiveType", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.primitiveType
                    } else {
                        (it.target as? ItemTagType.PrimitiveTagType<Any>)?.fromPrimitive(
                            it.getRef(0)!!,
                            it.getRef(1) as ItemTagAdapterContext
                        )
                    }
                }
                .function("primitiveType", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.primitiveType
                    } else {
                        (it.target as? ItemTagType.PrimitiveTagType<Any>)?.fromPrimitive(
                            it.getRef(0)!!,
                            it.getRef(1) as ItemTagAdapterContext
                        )
                    }
                }
                .function("complexType", returnsObject().noParams()) { it.target?.complexType }
                .function("toPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    (it.target as? ItemTagType.PrimitiveTagType<Any>)?.toPrimitive(
                        it.getRef(0)!!,
                        it.getRef(1) as ItemTagAdapterContext
                    )
                }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.meta.tags.ItemTagType.PrimitiveTagType"])
@PlatformSide(Platform.BUKKIT)
object FnItemTagTypePrimitiveTagType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemTagType.PrimitiveTagType::class.java)
                .function("primitiveType", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.primitiveType
                    } else {
                        (it.target as? ItemTagType.PrimitiveTagType<Any>)?.fromPrimitive(
                            it.getRef(0)!!,
                            it.getRef(1) as ItemTagAdapterContext
                        )
                    }
                }
                .function("primitiveType", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.primitiveType
                    } else {
                        (it.target as? ItemTagType.PrimitiveTagType<Any>)?.fromPrimitive(
                            it.getRef(0)!!,
                            it.getRef(1) as ItemTagAdapterContext
                        )
                    }
                }
                .function("complexType", returnsObject().noParams()) { it.target?.complexType }
                .function("toPrimitive", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    (it.target as? ItemTagType.PrimitiveTagType<Any>)?.toPrimitive(
                        it.getRef(0)!!,
                        it.getRef(1) as ItemTagAdapterContext
                    )
                }
        }
    }
}
