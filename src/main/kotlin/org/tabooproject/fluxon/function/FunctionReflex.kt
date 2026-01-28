package org.tabooproject.fluxon.function

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.library.reflex.Reflex.Companion.getProperty
import taboolib.library.reflex.Reflex.Companion.invokeMethod
import taboolib.library.reflex.Reflex.Companion.setProperty

object FunctionReflex {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Any::class.java)
                .function("property", returnsObject().params(Type.STRING)) {
                    it.target?.getProperty<Any?>(it.getString(0)!!, findToParent = true, remap = true)
                }
                .function("property", returnsObject().params(Type.STRING, Type.Z)) {
                    it.target?.getProperty<Any?>(it.getString(0)!!, findToParent = it.getBool(1), remap = true)
                }
                .function("property", returnsObject().params(Type.STRING, Type.Z, Type.Z)) {
                    it.target?.getProperty<Any?>(it.getString(0)!!, findToParent = it.getBool(1), remap = it.getBool(2))
                }
                .function("staticProperty", returnsObject().params(Type.STRING)) {
                    it.target?.getProperty<Any?>(it.getString(0)!!, isStatic = true, findToParent = true, remap = true)
                }
                .function("staticProperty", returnsObject().params(Type.STRING, Type.Z)) {
                    it.target?.getProperty<Any?>(it.getString(0)!!, isStatic = true, findToParent = it.getBool(1), remap = true)
                }
                .function("staticProperty", returnsObject().params(Type.STRING, Type.Z, Type.Z)) {
                    it.target?.getProperty<Any?>(it.getString(0)!!, isStatic = true, findToParent = it.getBool(1), remap = it.getBool(2))
                }
                .function("setProperty", returnsVoid().params(Type.STRING, Type.OBJECT)) {
                    it.target?.setProperty(it.getString(0)!!, it.getRef(1), findToParent = true, remap = true)
                }
                .function("setProperty", returnsVoid().params(Type.STRING, Type.OBJECT, Type.Z)) {
                    it.target?.setProperty(it.getString(0)!!, it.getRef(1), findToParent = it.getBool(2), remap = true)
                }
                .function("setProperty", returnsVoid().params(Type.STRING, Type.OBJECT, Type.Z, Type.Z)) {
                    it.target?.setProperty(it.getString(0)!!, it.getRef(1), findToParent = it.getBool(2), remap = it.getBool(3))
                }
                .function("setStaticProperty", returnsVoid().params(Type.STRING, Type.OBJECT)) {
                    it.target?.setProperty(it.getString(0)!!, it.getRef(1), isStatic = true, findToParent = true, remap = true)
                }
                .function("setStaticProperty", returnsVoid().params(Type.STRING, Type.OBJECT, Type.Z)) {
                    it.target?.setProperty(it.getString(0)!!, it.getRef(1), isStatic = true, findToParent = it.getBool(2), remap = true)
                }
                .function("setStaticProperty", returnsVoid().params(Type.STRING, Type.OBJECT, Type.Z, Type.Z)) {
                    it.target?.setProperty(it.getString(0)!!, it.getRef(1), isStatic = true, findToParent = it.getBool(2), remap = it.getBool(3))
                }
                .function("invokeMethod", returnsObject().params(Type.STRING, Type.LIST)) {
                    @Suppress("UNCHECKED_CAST")
                    val parameters = (it.getRef(1) as List<Any?>).toTypedArray()
                    it.target?.invokeMethod<Any?>(it.getString(0)!!, *parameters, findToParent = true, remap = true)
                }
                .function("invokeMethod", returnsObject().params(Type.STRING, Type.LIST, Type.Z)) {
                    @Suppress("UNCHECKED_CAST")
                    val parameters = (it.getRef(1) as List<Any?>).toTypedArray()
                    it.target?.invokeMethod<Any?>(it.getString(0)!!, *parameters, findToParent = it.getBool(2), remap = true)
                }
                .function("invokeMethod", returnsObject().params(Type.STRING, Type.LIST, Type.Z, Type.Z)) {
                    @Suppress("UNCHECKED_CAST")
                    val parameters = (it.getRef(1) as List<Any?>).toTypedArray()
                    it.target?.invokeMethod<Any?>(it.getString(0)!!, *parameters, findToParent = it.getBool(2), remap = it.getBool(3))
                }
                .function("invokeStaticMethod", returnsObject().params(Type.STRING, Type.LIST)) {
                    @Suppress("UNCHECKED_CAST")
                    val parameters = (it.getRef(1) as List<Any?>).toTypedArray()
                    it.target?.invokeMethod<Any?>(it.getString(0)!!, *parameters, isStatic = true, findToParent = true, remap = true)
                }
                .function("invokeStaticMethod", returnsObject().params(Type.STRING, Type.LIST, Type.Z)) {
                    @Suppress("UNCHECKED_CAST")
                    val parameters = (it.getRef(1) as List<Any?>).toTypedArray()
                    it.target?.invokeMethod<Any?>(it.getString(0)!!, *parameters, isStatic = true, findToParent = it.getBool(2), remap = true)
                }
                .function("invokeStaticMethod", returnsObject().params(Type.STRING, Type.LIST, Type.Z, Type.Z)) {
                    @Suppress("UNCHECKED_CAST")
                    val parameters = (it.getRef(1) as List<Any?>).toTypedArray()
                    it.target?.invokeMethod<Any?>(it.getString(0)!!, *parameters, isStatic = true, findToParent = it.getBool(2), remap = it.getBool(3))
                }
        }
    }
}
