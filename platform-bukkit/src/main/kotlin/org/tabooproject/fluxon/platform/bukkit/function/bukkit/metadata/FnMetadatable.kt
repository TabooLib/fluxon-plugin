package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import taboolib.platform.util.getMetaFirstOrNull
import taboolib.platform.util.hasMeta
import taboolib.platform.util.removeMeta
import taboolib.platform.util.setMeta
import org.bukkit.metadata.MetadataValue
import org.bukkit.metadata.Metadatable
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.metadata.Metadatable"])
@PlatformSide(Platform.BUKKIT)
object FnMetadatable {

    val TYPE = Type.fromClass(Metadatable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Metadatable::class.java)
                .function("setMeta", returnsVoid().params(Type.STRING, Type.OBJECT)) {
                    it.target?.setMeta(it.getString(0)!!, it.getRef(1)!!)
                }
                .function("removeMeta", returnsVoid().params(Type.STRING)) { it.target?.removeMeta(it.getString(0)!!) }
                .function("hasMeta", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(it.target?.hasMeta(it.getString(0)!!) ?: false)
                }
                .function("getMeta", returns(Type.OBJECT).params(Type.STRING)) {
                    it.setReturnRef(it.target?.getMetaFirstOrNull(it.getString(0)!!)?.value())
                }
                .function("setMetadata",returnsVoid().params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata.FnMetadataValue.TYPE)) {
                    it.target?.setMetadata(
                        it.getString(0)!!,
                        it.getRef(1) as MetadataValue
                    )
                }
                .function("getMetadata",returns(Type.LIST).params(Type.STRING)) { it.setReturnRef(it.target?.getMetadata(it.getString(0)!!)) }
                .function("hasMetadata", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(it.target?.hasMetadata(it.getString(0)!!) ?: false)
                }
                .function("removeMetadata",returnsVoid().params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.target?.removeMetadata(
                        it.getString(0)!!,
                        it.getRef(1) as Plugin
                    )
                }
        }
    }
}
