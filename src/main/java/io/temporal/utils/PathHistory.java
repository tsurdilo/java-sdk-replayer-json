package io.temporal.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathHistory {
    public static String replace(String jsonHistory) {
        // Replace all event types
        String regexEventType = "\"eventType\": \"(?<eventTypeVal>\\w+)\"";
        Pattern eventTypePattern = Pattern.compile(regexEventType);
        Matcher eventTypeMatcher = eventTypePattern.matcher(jsonHistory);

        while (eventTypeMatcher.find()) {
            jsonHistory = jsonHistory.replaceAll(eventTypeMatcher.group("eventTypeVal"), forEvent(eventTypeMatcher.group("eventTypeVal")));
        }

        // replace all task queue kinds
        String regexTaskQueueKind = "\"kind\": \"(?<taskQueueKindVal>\\w+)\"";
        Pattern taskQueueKindPattern = Pattern.compile(regexTaskQueueKind);
        Matcher taskQueueKindMatcher = taskQueueKindPattern.matcher(jsonHistory);

        while (taskQueueKindMatcher.find()) {
            jsonHistory = jsonHistory.replaceAll(taskQueueKindMatcher.group("taskQueueKindVal"), forTaskQueueKind(taskQueueKindMatcher.group("taskQueueKindVal")));
        }

        return jsonHistory;
    }

    private static String forTaskQueueKind(String taskQueueKind) {
        switch (taskQueueKind) {
            case "Unspecified": return "TASK_QUEUE_KIND_UNSPECIFIED";
            case "Normal": return "TASK_QUEUE_KIND_NORMAL";
            case "Sticky": return "TASK_QUEUE_KIND_STICKY";
            default: return "";
        }
    }

    private static String forEvent(String event) {
        switch (event) {
            case "Unspecified": return "EVENT_TYPE_UNSPECIFIED";
            case "WorkflowExecutionStarted": return "EVENT_TYPE_WORKFLOW_EXECUTION_STARTED";
            case "WorkflowExecutionCompleted": return "EVENT_TYPE_WORKFLOW_EXECUTION_COMPLETED";
            case "WorkflowExecutionFailed": return "EVENT_TYPE_WORKFLOW_EXECUTION_FAILED";
            case "WorkflowExecutionTimedOut": return "EVENT_TYPE_WORKFLOW_EXECUTION_TIMED_OUT";
            case "WorkflowTaskScheduled": return "EVENT_TYPE_WORKFLOW_TASK_SCHEDULED";
            case "WorkflowTaskStarted": return "EVENT_TYPE_WORKFLOW_TASK_STARTED";
            case "WorkflowTaskCompleted": return "EVENT_TYPE_WORKFLOW_TASK_COMPLETED";
            case "WorkflowTaskTimedOut": return "EVENT_TYPE_WORKFLOW_TASK_TIMED_OUT";
            case "WorkflowTaskFailed": return "EVENT_TYPE_WORKFLOW_TASK_FAILED";
            case "ActivityTaskScheduled": return "EVENT_TYPE_ACTIVITY_TASK_SCHEDULED";
            case "ActivityTaskStarted": return "EVENT_TYPE_ACTIVITY_TASK_STARTED";
            case "ActivityTaskCompleted": return "EVENT_TYPE_ACTIVITY_TASK_COMPLETED";
            case "ActivityTaskFailed": return "EVENT_TYPE_ACTIVITY_TASK_FAILED";
            case "ActivityTaskTimedOut": return "EVENT_TYPE_ACTIVITY_TASK_TIMED_OUT";
            case "ActivityTaskCancelRequested": return "EVENT_TYPE_ACTIVITY_TASK_CANCEL_REQUESTED";
            case "ActivityTaskCancelled": return "EVENT_TYPE_ACTIVITY_TASK_CANCELED";
            case "TimerStarted": return "EVENT_TYPE_TIMER_STARTED";
            case "TimerFired": return "EVENT_TYPE_TIMER_FIRED";
            case "TimerCancelled": return "EVENT_TYPE_TIMER_CANCELED";
            case "WorkflowExecutionCancelRequested": return "EVENT_TYPE_WORKFLOW_EXECUTION_CANCEL_REQUESTED";
            case "WorkflowExecutionCancelCancelled": return "EVENT_TYPE_WORKFLOW_EXECUTION_CANCELED";
            case "RequestCancelExternalWorkflowExecutionInitiated": return "EVENT_TYPE_REQUEST_CANCEL_EXTERNAL_WORKFLOW_EXECUTION_INITIATED";
            case "RequestCancelExternalWorkflowExecutionFailed": return "EVENT_TYPE_REQUEST_CANCEL_EXTERNAL_WORKFLOW_EXECUTION_FAILED";
            case "ExternalWorkflowExecutionCancelRequested": return "EVENT_TYPE_EXTERNAL_WORKFLOW_EXECUTION_CANCEL_REQUESTED";
            case "MarkerRecorded": return "EVENT_TYPE_MARKER_RECORDED";
            case "WorkflowExecutionSignaled": return "EVENT_TYPE_WORKFLOW_EXECUTION_SIGNALED";
            case "WorkflowExecutionTerminated": return "EVENT_TYPE_WORKFLOW_EXECUTION_TERMINATED";
            case "WorkflowExecutionContinuedAsNew": return "EVENT_TYPE_WORKFLOW_EXECUTION_CONTINUED_AS_NEW";
            case "StartChildWorkflowExecutionInitiated": return "EVENT_TYPE_START_CHILD_WORKFLOW_EXECUTION_INITIATED";
            case "StartChildWorkflowExecutionFailed": return "EVENT_TYPE_START_CHILD_WORKFLOW_EXECUTION_FAILED";
            case "ChildWorkflowExecutionStarted": return "EVENT_TYPE_CHILD_WORKFLOW_EXECUTION_STARTED";
            case "ChildWorkflowExecutionCompleted": return "EVENT_TYPE_CHILD_WORKFLOW_EXECUTION_COMPLETED";
            case "ChildWorkflowExecutionFailed": return "EVENT_TYPE_CHILD_WORKFLOW_EXECUTION_FAILED";
            case "ChildWorkflowExecutionCancelled": return "EVENT_TYPE_CHILD_WORKFLOW_EXECUTION_CANCELED";
            case "ChildWorkflowExecutionTimedOut": return "EVENT_TYPE_CHILD_WORKFLOW_EXECUTION_TIMED_OUT";
            case "ChildWorkflowExecutionTerminated": return "EVENT_TYPE_CHILD_WORKFLOW_EXECUTION_TERMINATED";
            case "SignalExternalWorkflowExecutionInitiated": return "EVENT_TYPE_SIGNAL_EXTERNAL_WORKFLOW_EXECUTION_INITIATED";
            case "SignalExternalWorkflowExecutionFailed": return "EVENT_TYPE_SIGNAL_EXTERNAL_WORKFLOW_EXECUTION_FAILED";
            case "ExternalWorkflowExecutionSignaled": return "EVENT_TYPE_EXTERNAL_WORKFLOW_EXECUTION_SIGNALED";
            case "UpsertWorkflowSearchAttributes": return "EVENT_TYPE_UPSERT_WORKFLOW_SEARCH_ATTRIBUTES";
            default: return "";
        }
    }
}
