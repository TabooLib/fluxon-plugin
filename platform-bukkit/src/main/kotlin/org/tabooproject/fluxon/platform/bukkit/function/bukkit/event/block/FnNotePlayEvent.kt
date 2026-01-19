package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.Instrument
import org.bukkit.Note
import org.bukkit.event.block.NotePlayEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnNotePlayEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NotePlayEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("instrument", 0) { it.target?.instrument }
                .function("note", 0) { it.target?.note }
                .function("setInstrument", 1) { it.target?.setInstrument(it.getArgument(0) as Instrument) }
                .function("setNote", 1) { it.target?.setNote(it.getArgument(0) as Note) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { NotePlayEvent.getHandlerList() }
        }
    }
}
