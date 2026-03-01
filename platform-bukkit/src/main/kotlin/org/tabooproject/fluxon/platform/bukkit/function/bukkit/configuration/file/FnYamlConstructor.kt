package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.configuration.file.YamlConstructor"])
@PlatformSide(Platform.BUKKIT)
object FnYamlConstructor {

    val TYPE = Type.fromClass(org.bukkit.configuration.file.YamlConstructor::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.configuration.file.YamlConstructor::class.java)
                .function("flattenMapping", returnsVoid().params(Type.fromClass(org.yaml.snakeyaml.nodes.MappingNode::class.java))) { it.target?.flattenMapping(it.getRef(0) as org.yaml.snakeyaml.nodes.MappingNode) }
                .function("construct", returns(Type.OBJECT).params(Type.fromClass(org.yaml.snakeyaml.nodes.Node::class.java))) { it.setReturnRef(it.target?.construct(it.getRef(0) as org.yaml.snakeyaml.nodes.Node)) }
        }
    }
}
