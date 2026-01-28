package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Note
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.Note"])
@PlatformSide(Platform.BUKKIT)
object FnNote {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Note::class.java)
                // static
                .function("flat", returnsObject().params(Type.OBJECT, Type.OBJECT)) { Note.flat(it.getInt(0).toInt(), it.getRef(1) as Note.Tone) }
                // static
                .function("sharp", returnsObject().params(Type.OBJECT, Type.OBJECT)) { Note.sharp(it.getInt(0).toInt(), it.getRef(1) as Note.Tone) }
                // static
                .function("natural", returnsObject().params(Type.OBJECT, Type.OBJECT)) { Note.natural(it.getInt(0).toInt(), it.getRef(1) as Note.Tone) }
                .function("sharped", returnsObject().noParams()) { it.target?.sharped() }
                .function("flattened", returnsObject().noParams()) { it.target?.flattened() }
                .function("id", returnsObject().noParams()) {
                    it.target?.id
                }
                .function("octave", returnsObject().noParams()) { it.target?.octave }
                .function("tone", returnsObject().noParams()) { it.target?.tone }
                .function("isSharped", returns(Type.Z).noParams()) { it.target?.isSharped }
                .function("pitch", returnsObject().noParams()) { it.target?.pitch }
                .function("hashCode", returns(Type.I).noParams()) { it.target?.hashCode() }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.target?.equals(it.getRef(0)) }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
        }
    }
}

@Requires(classes = ["org.bukkit.Note.Tone"])
@PlatformSide(Platform.BUKKIT)
object FnNoteTone {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Note.Tone::class.java)
                .function("getId", returnsObject().params(Type.OBJECT)) { it.target?.getId(it.getBool(0)) }
                .function("isSharpable", returns(Type.Z).noParams()) { it.target?.isSharpable }
                .function("isSharped", returns(Type.Z).params(Type.OBJECT)) { it.target?.isSharped(it.getInt(0).toByte()) }
                // static
                .function("getById", returnsObject().params(Type.OBJECT)) { Note.Tone.getById(it.getInt(0).toByte()) }
        }
    }
}
