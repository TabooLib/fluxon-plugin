package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.Instrument
import org.bukkit.Note
import org.bukkit.event.block.NotePlayEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.block.NotePlayEvent"])
@PlatformSide(Platform.BUKKIT)
object FnNotePlayEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NotePlayEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("instrument", returnsObject().noParams()) { it.setReturnRef(it.target?.instrument) }
                .function("note", returnsObject().noParams()) { it.setReturnRef(it.target?.note) }
                .function("setInstrument", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setInstrument(it.getRef(0) as Instrument)) }
                .function("setNote", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setNote(it.getRef(0) as Note)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(NotePlayEvent.getHandlerList()) }
        }
    }
}
