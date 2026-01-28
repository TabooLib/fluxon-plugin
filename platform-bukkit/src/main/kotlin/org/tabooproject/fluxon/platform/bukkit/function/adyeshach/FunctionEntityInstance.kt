package org.tabooproject.fluxon.platform.bukkit.function.adyeshach

import ink.ptms.adyeshach.core.entity.EntityInstance
import ink.ptms.adyeshach.core.entity.ModelEngine
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@Requires(classes = ["ink.ptms.adyeshach.core.Adyeshach"])
@PlatformSide(Platform.BUKKIT)
object FunctionEntityInstance {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityInstance::class.java)
                // 函数
                .function("respawn", returnsVoid().noParams()) {
                    it.target?.respawn()
                }
                // 属性
                .function("location", returnsObject().noParams()) {
                    it.target?.getLocation()
                }
                // 载具
                .function("passengers", returns(Type.LIST).noParams()) {
                    it.target?.getPassengers()
                }
                .function("refreshPassenger", returnsVoid().noParams()) {
                    it.target?.refreshPassenger()
                }
                // 标签
                .function("setTag", returnsVoid().params(Type.STRING, Type.OBJECT)) {
                    val value = it.getRef(1)
                    if (value != null) {
                        it.target?.setTag(it.getString(0)!!, value)
                    } else {
                        it.target?.removeTag(it.getString(0)!!)
                    }
                }
                .function("setPersistentTag", returnsVoid().params(Type.STRING, Type.OBJECT)) {
                    val value = it.getRef(1)
                    if (value != null) {
                        it.target?.setPersistentTag(it.getString(0)!!, value.toString())
                    } else {
                        it.target?.removePersistentTag(it.getString(0)!!)
                    }
                }
                .function("hasTag", returns(Type.Z).params(Type.STRING)) {
                    it.target?.hasTag(it.getString(0)!!)
                }
                .function("hasPersistentTag", returns(Type.Z).params(Type.STRING)) {
                    it.target?.hasPersistentTag(it.getString(0)!!)
                }
                .function("getTag", returnsObject().params(Type.STRING)) {
                    it.target?.getTag(it.getString(0)!!)
                }
                .function("consumeTag", returnsObject().params(Type.STRING)) {
                    val id = it.getString(0)!!
                    val find = it.target?.getTag(id)
                    it.target?.removeTag(id)
                    find
                }
                .function("getPersistentTag", returns(Type.STRING).params(Type.STRING)) {
                    it.target?.getPersistentTag(it.getString(0)!!)
                }
                .function("consumePersistentTag", returns(Type.STRING).params(Type.STRING)) {
                    val id = it.getString(0)!!
                    val find = it.target?.getPersistentTag(id)
                    it.target?.removePersistentTag(id)
                    find
                }
                .function("tags", returns(Type.MAP).noParams()) {
                    it.target?.getTags()
                }
                .function("persistentTags", returns(Type.MAP).noParams()) {
                    it.target?.getPersistentTags()
                }
                // 模型
                .function("modelEngineName", returns(Type.STRING).noParams()) {
                    val target = it.target as ModelEngine
                    target.modelEngineName
                }
                .function("modelEngineUniqueId", returnsObject().noParams()) {
                    val target = it.target as ModelEngine
                    target.modelEngineUniqueId
                }
                .function("refreshModelEngine", returnsVoid().noParams()) {
                    val target = it.target as ModelEngine
                    target.refreshModelEngine()
                }
                // 管理器
                .function("manager", returnsObject().noParams()) {
                    it.target?.manager
                }
        }
    }
}
