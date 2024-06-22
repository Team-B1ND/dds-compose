package com.b1nd.dodam.designsystem.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.b1nd.dodam.designsystem.R

enum class DodamIcons {
    Home,
    ForkAndKnife,
    DoorOpen,
    Calendar,
    MoonPlus,
    Menu,
    XMarkCircle,
    ExclamationMarkCircle,
    Plus,
    Note,
    Bus,
    Megaphone,
    ArrowLeft,
    Bell,
    Eye,
    EyeSlash,
    Checkmark,
    CheckmarkCircle,
    CheckmarkCircleFilled,
    ChevronRight,
    Trash,
    MagnifyingGlass,
    Gear;

    val value: ImageVector
        @Composable
        get() = when (this) {
            Home -> ImageVector.vectorResource(R.drawable.ic_home)
            ForkAndKnife -> ImageVector.vectorResource(R.drawable.ic_fork_and_knife)
            DoorOpen -> ImageVector.vectorResource(R.drawable.ic_door_open)
            Calendar -> ImageVector.vectorResource(R.drawable.ic_calendar)
            MoonPlus -> ImageVector.vectorResource(R.drawable.ic_moon_plus)
            Menu -> ImageVector.vectorResource(R.drawable.ic_menu)
            XMarkCircle -> ImageVector.vectorResource(R.drawable.ic_xmark_circle)
            ExclamationMarkCircle -> ImageVector.vectorResource(R.drawable.ic_exclamationmark_circle)
            Plus -> ImageVector.vectorResource(R.drawable.ic_plus)
            Note -> ImageVector.vectorResource(R.drawable.ic_note)
            Bus -> ImageVector.vectorResource(R.drawable.ic_bus)
            Megaphone -> ImageVector.vectorResource(R.drawable.ic_megaphone)
            ArrowLeft -> ImageVector.vectorResource(R.drawable.ic_arrow_left)
            Bell -> ImageVector.vectorResource(R.drawable.ic_bell)
            Eye -> ImageVector.vectorResource(R.drawable.ic_eye)
            EyeSlash -> ImageVector.vectorResource(R.drawable.ic_eye_slash)
            Checkmark -> ImageVector.vectorResource(R.drawable.ic_checkmark)
            CheckmarkCircle -> ImageVector.vectorResource(R.drawable.ic_checkmark_circle)
            CheckmarkCircleFilled -> ImageVector.vectorResource(R.drawable.ic_checkmark_circle_filled)
            ChevronRight -> ImageVector.vectorResource(R.drawable.ic_chevron_right)
            Trash -> ImageVector.vectorResource(R.drawable.ic_trash)
            MagnifyingGlass -> ImageVector.vectorResource(R.drawable.ic_magnifyingglass)
            Gear -> ImageVector.vectorResource(R.drawable.ic_gear)
        }
}
