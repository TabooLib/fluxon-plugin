package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.metadata.MetadataStoreBase"])
@PlatformSide(Platform.BUKKIT)
object FnMetadataStoreBase {

    val TYPE = Type.fromClass(org.bukkit.metadata.MetadataStoreBase::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.metadata.MetadataStoreBase::class.java)
                // .function("setMetadata", returnsVoid().params(Type.OBJECT, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata.FnMetadataValue.TYPE)) { it.target?.setMetadata(it.getRef(0) as java.lang.Object, it.getString(1), it.getRef(2) as org.bukkit.metadata.MetadataValue) }
                // .function("getMetadata", returns(Type.LIST).params(Type.OBJECT, Type.STRING)) { it.setReturnRef(it.target?.getMetadata(it.getRef(0) as java.lang.Object, it.getString(1))) }
                // .function("hasMetadata", returns(Type.Z).params(Type.OBJECT, Type.STRING)) { it.setReturnBool(it.target?.hasMetadata(it.getRef(0) as java.lang.Object, it.getString(1)) ?: false) }
                // .function("removeMetadata", returnsVoid().params(Type.OBJECT, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.target?.removeMetadata(it.getRef(0) as java.lang.Object, it.getString(1), it.getRef(2) as org.bukkit.plugin.Plugin) }
                .function("invalidateAll", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.target?.invalidateAll(it.getRef(0) as org.bukkit.plugin.Plugin) }
                // .function("removeAll", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.target?.removeAll(it.getRef(0) as org.bukkit.plugin.Plugin) }
                // .function("disambiguate", returns(Type.STRING).params(Type.OBJECT, Type.STRING)) { it.setReturnRef(it.target?.disambiguate(it.getRef(0) as java.lang.Object, it.getString(1))) }
        }
    }
}
