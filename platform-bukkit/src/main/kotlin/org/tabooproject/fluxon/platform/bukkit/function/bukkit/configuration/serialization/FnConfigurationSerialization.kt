package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.serialization

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.configuration.serialization.ConfigurationSerialization"])
@PlatformSide(Platform.BUKKIT)
object FnConfigurationSerialization {

    val TYPE = Type.fromClass(org.bukkit.configuration.serialization.ConfigurationSerialization::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.configuration.serialization.ConfigurationSerialization::class.java)
                // static deserializeObject
                // static getAlias
                // static getClassByAlias
                // static registerClass
                // static unregisterClass
                // .function("getMethod", returns(Type.fromClass(java.lang.reflect.Method::class.java)).params(Type.STRING, Type.Z)) { it.setReturnRef(it.target?.getMethod(it.getString(0), it.getBool(1))) }
                // .function("getConstructor", returns(Type.fromClass(java.lang.reflect.Constructor::class.java)).noParams()) { it.setReturnRef(it.target?.getConstructor()) }
                // .function("deserializeViaMethod", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.serialization.FnConfigurationSerializable.TYPE).params(Type.fromClass(java.lang.reflect.Method::class.java), Type.MAP)) { it.setReturnRef(it.target?.deserializeViaMethod(it.getRef(0) as java.lang.reflect.Method, it.getRef(1) as java.util.Map)) }
                // .function("deserializeViaCtor", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.serialization.FnConfigurationSerializable.TYPE).params(Type.fromClass(java.lang.reflect.Constructor::class.java), Type.MAP)) { it.setReturnRef(it.target?.deserializeViaCtor(it.getRef(0) as java.lang.reflect.Constructor, it.getRef(1) as java.util.Map)) }
                // .function("deserialize", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.serialization.FnConfigurationSerializable.TYPE).params(Type.MAP)) { it.setReturnRef(it.target?.deserialize(it.getRef(0) as java.util.Map)) }
        }
    }
}
